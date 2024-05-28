package pis.coursework.backend.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pis.coursework.backend.dto.SubscriptionDto;
import pis.coursework.backend.entity.Subscription;
import pis.coursework.backend.mapper.SubscriptionMapper;
import pis.coursework.backend.repository.SubscriptionRepo;
import pis.coursework.backend.repository.UserRepo;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepo subscriptionRepo;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepo userRepo;

    @Transactional(readOnly = true)
    public SubscriptionDto getSubscriptionById(Long subscriptionId) {
        return subscriptionMapper.toDto(subscriptionRepo.findById(subscriptionId).orElseThrow(() ->
                new EntityExistsException("Абонемента по такому id не существует")));
    }

    @Transactional(readOnly = true)
    public ArrayList<SubscriptionDto> getAllSubscriptions() {
        return subscriptionMapper.listToDto(subscriptionRepo.getAllSubscriptions());
    }

    @Transactional
    public void createSubscription(SubscriptionDto subscriptionDto) {
        subscriptionRepo.save(Subscription.builder()
                .user(userRepo.getUserById(subscriptionDto.getUserId()))
                .dateSub(subscriptionDto.getDateSub())
                .dateEnd(subscriptionDto.getDateEnd())
                .numberTicket(subscriptionDto.getNumberTicket())
                .build());
    }

    @Transactional
    public void deleteSubscription(Long subscriptionId) {
        if (subscriptionRepo.getSubscriptionById(subscriptionId) == null) {
            throw new EntityExistsException("Абонемента по такому id не существует");
        }
        subscriptionRepo.deleteById(subscriptionId);
    }

    @Transactional
    public void updateSubscription(Long subscriptionId, SubscriptionDto subscriptionDto) {
        if (subscriptionRepo.getSubscriptionById(subscriptionId) == null) {
            throw new EntityExistsException("Абонемента по такому id не существует");
        }
        Subscription updatedSubscription = subscriptionMapper.toEntity(subscriptionDto);
        updatedSubscription.setId(subscriptionId);
        subscriptionRepo.save(updatedSubscription);
    }


}
