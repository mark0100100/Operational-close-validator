package com.marceloituccayasi.ocv.operationalclose.application.port.repository;

import java.util.Optional;

import com.marceloituccayasi.ocv.operationalclose.domain.EventStateTransition;
import com.marceloituccayasi.ocv.operationalclose.domain.OperationalEvent;
import com.marceloituccayasi.ocv.operationalclose.domain.OperationalEventId;

/**
 * Persistence contract for revising Operational Events under
 * pessimistic database locking.
 */
public interface OperationalEventRevisionRepository {

    Optional<OperationalEvent> findByIdForUpdate(
            OperationalEventId eventId);

    Optional<OperationalEvent>
            findCancellationByReversedEventIdForUpdate(
                    OperationalEventId reversedEventId);

    void saveRevision(
            OperationalEvent operationalEvent);

    void appendStateTransition(
            EventStateTransition stateTransition);

}