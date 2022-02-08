package com.example.washingproject.controller;

import com.example.washingproject.booking.Booking;
import com.example.washingproject.booking.BookingRepository;
import com.example.washingproject.request.BookingWashingResponse;
import com.example.washingproject.user.User;
import com.example.washingproject.user.UserRepository;
import com.example.washingproject.washer.Washer;
import com.example.washingproject.washer.WasherRepository;
import com.example.washingproject.washerbook.WasherBookRepository;
import com.example.washingproject.washerbook.WasherBooked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Controller
public class WashingController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WasherRepository washerRepository;

    @Autowired
    BookingRepository bookingRepository;


    @Autowired
    WasherBookRepository washerBookRepository;

    private String UserName=null;

    private Long machineId;

    @GetMapping("/")
    public String showForm() {
        this.UserName = null;
        return "login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        this.UserName = null;
        return "login";
    }

    @PostMapping("/login")
    @Transactional
    public String doLogin(@ModelAttribute("user") User user){
        System.out.println("User Name received for login is "+user.getUserName());
        User existing = userRepository.findUserByUserName(user.getUserName());
        if (existing != null){
            if(user.getPassword().equals(existing.getPassword())){
                // means it is a simple user login
                this.UserName=user.getUserName();
                return "redirect:/order";
            }
        }
        return "redirect:/login?failure";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    @Transactional
    public String registerUserAccount(@ModelAttribute("user") User userDto){

        System.out.println("User Name received is "+userDto.getUserName());
        User existing = userRepository.findUserByUserName(userDto.getUserName());
        if (existing != null){
            return "redirect:/registration?failure";
        }
        userRepository.save(userDto);
        return "login";
    }

    @GetMapping("/order")
    public String showUserMachine(Model model){
        if(this.UserName != null ){
            List<Washer> washerList=washerRepository.findWasherByBooked(false);
            model.addAttribute("washingItems",washerList);
            return "bookwashing";
        }
        return "redirect:/login";
    }

    @GetMapping("/book/machine/{id}")
    public String bookMachineById(@PathVariable("id") Long id, Model model)
    {
        if(this.UserName != null ){
            this.machineId=id;
            return "bookwashingadd";
        }
        return "redirect:/login";
    }

    @PostMapping("/book/machine")
    @Transactional
    public String bookUserMachine(@ModelAttribute("machine") Booking booking){
        if (this.UserName != null ){
            WasherBooked washerBooked =washerBookRepository.findWasherBookedByWasherId(this.machineId);
            if(washerBooked == null){
                booking.setUserName(this.UserName);
                Booking temp=bookingRepository.save(booking);

                WasherBooked washerBooked1=new WasherBooked();
                washerBooked1.setWasherId(this.machineId);
                washerBooked1.setBookingId(temp.getId());
                washerBookRepository.save(washerBooked1);

                Washer washer=washerRepository.findWasherById(this.machineId);
                if(washer !=null){
                    washer.setBooked(true);
                    washerRepository.save(washer);
                }
                return "redirect:/order";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/book/machines")
    public String bookMachines(Model model)
    {
        if(this.UserName != null ){
            List<Booking> bookingList=bookingRepository.findBookingsByUserName(this.UserName);
            List<BookingWashingResponse> bookingWashingResponseList=new ArrayList<>();
            for(Booking booking:bookingList){
                WasherBooked washerBooked=washerBookRepository.findWasherBookedByBookingId(booking.getId());
                if(washerBooked !=null){
                    Washer washer=washerRepository.findWasherById(washerBooked.getWasherId());
                    if(washer != null){
                        BookingWashingResponse bookingWashingResponse=new BookingWashingResponse();
                        bookingWashingResponse.setBookingId(booking.getId());
                        bookingWashingResponse.setWashingId(washerBooked.getWasherId());
                        bookingWashingResponse.setAutoPower(washer.isAutoPower());
                        bookingWashingResponse.setEnd(booking.getEnd());
                        bookingWashingResponse.setName(washer.getName());
                        bookingWashingResponse.setRoomNumber(booking.getRoomNumber());
                        bookingWashingResponse.setStart(booking.getStart());
                        bookingWashingResponse.setWeight(washer.getWeight());
                        bookingWashingResponseList.add(bookingWashingResponse);
                    }
                }
            }
            model.addAttribute("washingItems",bookingWashingResponseList);
            return "bookwashingshow";
        }
        return "redirect:/login";
    }

    @GetMapping("/remove/machine/{id}")
    public String reviewFoodFromCartById(@PathVariable("id") Long id)
    {
        if(this.UserName != null ){
            Long tempId=id;
            bookingRepository.deleteBookingById(id);
            WasherBooked washerBooked=washerBookRepository.findWasherBookedByBookingId(tempId);
            if(washerBooked !=null){
                Washer washer=washerRepository.findWasherById(washerBooked.getWasherId());
                if(washer !=null){
                    washer.setBooked(false);
                    washerRepository.save(washer);
                }
                washerBookRepository.deleteWasherBookedByBookingId(tempId);
            }

            return "redirect:/order";
        }
        return "redirect:/login";
    }

}
