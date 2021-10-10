package jpaBook.springJpa01.service;

import jpaBook.springJpa01.domain.item.Album;
import jpaBook.springJpa01.domain.item.Book;
import jpaBook.springJpa01.domain.item.Item;
import jpaBook.springJpa01.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    EntityManager em;

    @Test
    public void 상품등록() throws Exception {
        // given
        Item item1 = new Album();
        item1.setName("test1");
        item1.setPrice(3000);
        item1.setStockQuantity(50);

        Item item2 = new Book();
        item2.setName("test2");
        item2.setPrice(5000);
        item2.setStockQuantity(100);
        // when
        Long saveId1 = itemService.saveItem(item1);
        Long saveId2 = itemService.saveItem(item2);

        // then
        em.flush();
        assertEquals(item1, itemService.findOne(saveId1));
        assertEquals(item2, itemService.findOne(saveId2));
    }
}