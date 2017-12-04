package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {
    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testOneGetTrelloBoards() {
        //Given
        when(restTemplate.getForObject(trelloClient.buildUrl(), TrelloBoardDto[].class)).thenReturn(null);

        //When
        List<TrelloBoardDto> resultList = trelloClient.getTrelloBoards();

        //Then
        Assert.assertNotNull(resultList);
        Assert.assertEquals(0, resultList.size());
    }

    @Test
    public void testTwoeGetTrelloBoards() {
        //Given
        TrelloBoardDto[] boards = new TrelloBoardDto[3];
        when(restTemplate.getForObject(trelloClient.buildUrl(), TrelloBoardDto[].class)).thenReturn(boards);

        //When
        List<TrelloBoardDto> resultList = trelloClient.getTrelloBoards();

        //Then
        Assert.assertNotNull(resultList);
        Assert.assertEquals(3, resultList.size());
    }
}