//package com.marwit23.cook.delivery;
//
//import com.marwit23.cook._exception.EntityNotFoundException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//public class DeliveryServiceTest {
//
//    @InjectMocks
//    private DeliveryServiceImpl deliveryService;
//    @Mock
//    private DeliveryRepository deliveryRepository;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    // * GET METHOD-----------------------------------------------------------------------------------------------------
//
//    // * item id does not exist
//    @Test
//    public void testFindById_DoesNotExist(){
//        when(deliveryRepository.findById(anyLong())).thenReturn(Optional.empty());
//        Assertions.assertThrows(EntityNotFoundException.class, ()-> deliveryService.findById((long) 1000));
//    }
//}
