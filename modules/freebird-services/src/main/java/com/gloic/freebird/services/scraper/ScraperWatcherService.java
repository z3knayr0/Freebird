package com.gloic.freebird.services.scraper;

import com.gloic.freebird.services.parser.ItemToParse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gloic
 */
@Service
@Slf4j
public class ScraperWatcherService {
    private final ScraperService scraperService;

    private boolean isProcessing;
    private List<ItemToParse> items = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    public ScraperWatcherService(ScraperService scraperService) {
        this.scraperService = scraperService;
    }


    /**
     * Iterates over the list (FIFO) and scrape the items.
     */
    private void process() {
        isProcessing = true;

        log.info("Starting scraping process");
        while (items.size() > 0) {
            ItemToParse itemToParse = items.get(0);
            log.debug("Processing item {}", itemToParse.getFilename());
            scraperService.scrape(itemToParse);
            items.remove(0);
            if(items.size() % 100 == 0) {
                log.info("Number of items to scrape left : {}", items.size());
            }
        }
        isProcessing = false;
        log.info("Scraping finished.");
    }

    /**
     * Add an item to the list of item to scrape.
     * If the process is not started yet, starting it.
     * @param itemToParse
     */
    @Async
    public void addItem(ItemToParse itemToParse) {
        log.debug("Adding item {}", itemToParse.getFilename());
        items.add(itemToParse);
        if (!isProcessing) {
            process();
        }
    }

}