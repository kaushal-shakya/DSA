package lld2.facade.travelbookingplatform.solved;

import lld2.facade.travelbookingplatform.solved.models.BookingResult;
import lld2.facade.travelbookingplatform.solved.services.*;

import java.time.LocalDate;

public class BookingManager {

    private BookingFacade facade;
    public BookingManager(AvailabilityService availabilityService, PaymentService paymentService,
                          NotificationService notificationService, LoyaltyService loyaltyService,
                          AccommodationDetailsService accommodationDetailsService) {
        facade = new BookingFacade(availabilityService, paymentService, notificationService, loyaltyService, accommodationDetailsService);
    }

    public BookingResult book(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate){
        return facade.bookAccommodation(userId, accommodationId, checkInDate, checkOutDate);
    }
}
