package org.zenith.pay.demo.controller;

import org.zenith.pay.demo.model.Customer;
import org.zenith.pay.demo.model.Payment;
import org.zenith.pay.demo.model.Reservation;
import org.zenith.pay.demo.model.Room;
import org.zenith.pay.demo.security.HotelManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class HotelManagementController {

    @Autowired
    private HotelManagementService hotelManagementService;

    // Test endpoint
    @GetMapping("/test")
    public ResponseEntity<String> testConnection() {
        try {
            hotelManagementService.getAllCustomers();
            return ResponseEntity.ok("Database connection successful!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Database connection failed: " + e.getMessage());
        }
    }

    // Customer endpoints
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(hotelManagementService.createCustomer(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(hotelManagementService.getAllCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelManagementService.getCustomerById(id));
    }

    // Room endpoints
    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        return ResponseEntity.ok(hotelManagementService.createRoom(room));
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(hotelManagementService.getAllRooms());
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelManagementService.getRoomById(id));
    }

    @GetMapping("/rooms/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        return ResponseEntity.ok(hotelManagementService.getAvailableRooms());
    }

    // Reservation endpoints
    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(hotelManagementService.createReservation(reservation));
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(hotelManagementService.getAllReservations());
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelManagementService.getReservationById(id));
    }

    @PutMapping("/reservations/{id}/cancel")
    public ResponseEntity<Reservation> cancelReservation(@PathVariable Long id) {
        return ResponseEntity.ok(hotelManagementService.cancelReservation(id));
    }

    // Payment endpoints
    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(hotelManagementService.createPayment(payment));
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(hotelManagementService.getAllPayments());
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelManagementService.getPaymentById(id));
    }

    @GetMapping("/payments/reservation/{reservationId}")
    public ResponseEntity<List<Payment>> getPaymentsByReservation(@PathVariable Long reservationId) {
        return ResponseEntity.ok(hotelManagementService.getPaymentsByReservation(reservationId));
    }
}
