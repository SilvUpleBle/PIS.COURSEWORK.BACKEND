package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Subscription;

import java.util.ArrayList;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    Subscription getSubscriptionById(Long subscriptionId);

    @Query(value = "SELECT * FROM subscriptions", nativeQuery = true)
    ArrayList<Subscription> getAllSubscriptions();
    
}
