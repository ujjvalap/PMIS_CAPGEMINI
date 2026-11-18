package com.quickrelief.service;

import com.quickrelief.dto.AllocateSupplyRequest;
import com.quickrelief.exception.InsufficientStockException;
import com.quickrelief.model.SupplyRequest;
import com.quickrelief.repository.RequestRepository;
import com.quickrelief.repository.SupplyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AllocationServiceTest {

    @Mock
    private SupplyRepository supplyRepository;

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private AllocationService allocationService;

    @Test
    void shouldRecordRequestWhenStockIsAvailable() {
        when(supplyRepository.deductIfAvailable("First Aid Kit", 2))
            .thenReturn(1);
        when(requestRepository.insert("First Aid Kit", 2, "Medical Team"))
            .thenReturn(new SupplyRequest(
                1, "First Aid Kit", 2, "APPROVED", "Medical Team"));

        SupplyRequest result = allocationService.allocate(
            new AllocateSupplyRequest(" First Aid Kit ", 2, " Medical Team "));

        assertEquals("APPROVED", result.status());
        verify(requestRepository).insert("First Aid Kit", 2, "Medical Team");
    }

    @Test
    void shouldRejectRequestWhenStockIsInsufficient() {
        when(supplyRepository.deductIfAvailable("First Aid Kit", 2))
            .thenReturn(0);

        assertThrows(InsufficientStockException.class, () ->
            allocationService.allocate(
                new AllocateSupplyRequest("First Aid Kit", 2, "Medical Team")));

        verifyNoInteractions(requestRepository);
    }
}
