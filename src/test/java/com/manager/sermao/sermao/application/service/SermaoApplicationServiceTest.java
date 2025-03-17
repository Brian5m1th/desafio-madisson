package com.manager.sermao.sermao.application.service;

import com.manager.sermao.DataHelper;
import com.manager.sermao.handler.APIException;
import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.application.api.SermaoResponse;
import com.manager.sermao.sermao.application.repository.SermaoRepository;
import com.manager.sermao.sermao.domain.Sermao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SermaoApplicationServiceTest {

    @InjectMocks
    private SermaoApplicationService sermaoApplicationService;

    @Mock
    private SermaoRepository sermaoRepository;


    @Test
    void criaSermao() {

        SermaoRequest sermaoRequest = DataHelper.criaSermaoRequest();

        doNothing().when(sermaoRepository).salva(any(Sermao.class));


        SermaoResponse sermaoResponse = sermaoApplicationService.criaSermao(sermaoRequest);

        verify(sermaoRepository, times(1)).salva(any(Sermao.class));
        assertNotNull(sermaoResponse);
        assertEquals(SermaoResponse.class, sermaoResponse.getClass());
    }

    @Test
    void lancaExceptionAocriaSermao() {

        SermaoRequest sermaoRequest = DataHelper.criaSermaoRequest();

        when(sermaoRepository.existsByTemaAndIgrejaAndData(
                sermaoRequest.getTema(), sermaoRequest.getIgreja(), sermaoRequest.getData()))
                .thenReturn(true);

        APIException apiException = assertThrows(APIException.class, () -> sermaoApplicationService.criaSermao(sermaoRequest));

        assertEquals(HttpStatus.CONFLICT, apiException.getStatusException() );
        verify(sermaoRepository, never()).salva(any(Sermao.class));
    }
}