package com.openclassrooms.watchlist;

import com.openclassrooms.watchlist.domain.WatchlistItem;
import com.openclassrooms.watchlist.repository.WatchlistRepository;
import com.openclassrooms.watchlist.service.MovieRatingServiceImpl;
import com.openclassrooms.watchlist.service.WatchlistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WatchlistServiceTest {

    @Mock
    private WatchlistRepository watchlistRepositoryMock;

    @Mock
    private MovieRatingServiceImpl movieRatingServiceImplMock;

    @InjectMocks
    private WatchlistService watchlistService;

    @Test
    public void testGetWatchlistItems_ReturnsAllItemsFromRepository() {
        WatchlistItem item1 = new WatchlistItem("Star Wars","7.7","M","",1);
        WatchlistItem item2 = new WatchlistItem("Star Treck","8.7","M","",2);
        List<WatchlistItem> mockItems = Arrays.asList(item1,item2);

        when(watchlistRepositoryMock.getList()).thenReturn(mockItems);

        List<WatchlistItem> result = watchlistService.getWatchlistItems();

        assertTrue(result.size() == 2);
        assertTrue(result.get(0).getTitle().equals("Star Wars"));
        assertTrue(result.get(1).getTitle().equals("Star Treck"));
    }
}
