package jpaBook.springJpa01.service;

import jpaBook.springJpa01.domain.item.Book;
import jpaBook.springJpa01.domain.item.Item;
import jpaBook.springJpa01.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional // 저장하기 위해서 어노테이션 재설정
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        // 준영속 엔티티 수정
        // 변경 감지 기능 사용 -- Merge 사용 금지하는게 좋다
        Item findItem = itemRepository.findOne(itemId); // findItem 영속상태
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
