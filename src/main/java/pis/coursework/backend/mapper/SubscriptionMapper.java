package pis.coursework.backend.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pis.coursework.backend.dto.SubscriptionDto;
import pis.coursework.backend.entity.Subscription;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface SubscriptionMapper {

    SubscriptionDto toDto(Subscription subscription);

    Subscription toEntity(SubscriptionDto subscriptionDto);

    ArrayList<SubscriptionDto> listToDto(List<Subscription> subscriptions);

}
