package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TrelloClientTest {

    private final static URI TEST_URL = UriComponentsBuilder.fromHttpUrl("https://test.com").build().encode().toUri();

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getTrelloBoardsNoBoardsTest() {
        //Given
        when(restTemplate.getForObject(trelloClient.buildUrl(), TrelloBoardDto[].class)).thenReturn(null);

        //When
        List<TrelloBoardDto> resultListOfBoards = trelloClient.getTrelloBoards();

        //Then
        Assert.assertNotNull(resultListOfBoards);
    }

    @Test
    public void getTrelloBoardsListOfThreeBoardsTest() {
        //Given
        TrelloBoardDto[] sampleBoardDto = new TrelloBoardDto[3];
        when(restTemplate.getForObject(trelloClient.buildUrl(), TrelloBoardDto[].class)).thenReturn(sampleBoardDto);

        //When
        List<TrelloBoardDto> resultListOfBoards = trelloClient.getTrelloBoards();

        //Then
        Assert.assertEquals(3,resultListOfBoards.size());
    }
}