package com.rohit.dream_shops.service.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
// import java.util.concurrent.atomic.AtomicLong;

import com.rohit.dream_shops.exceptions.ResourceNotFoundException;
import com.rohit.dream_shops.model.Cart;
import com.rohit.dream_shops.model.User;
import com.rohit.dream_shops.repository.CartItemRepository;
import com.rohit.dream_shops.repository.CartRepository;


@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    // private final AtomicLong cartIdGenerator = new AtomicLong(0);

   
    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);
    }


    @Transactional
    @Override
    public void clearCart(Long id) {
        Cart cart = getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getItems().clear();
        cartRepository.deleteById(id);

    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getTotalAmount();
    }

    @Override
    public Cart initializeNewCart(User user) {
        return Optional.ofNullable(getCartByUserId(user.getId()))
        .orElseGet(() ->{
            Cart cart = new Cart();
            cart.setUser(user);
            return cartRepository.save(cart);
        });
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
    
}
