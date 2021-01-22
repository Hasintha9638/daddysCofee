package daddys.cofee.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daddys.cofee.springboot.model.Order;
import daddys.cofee.springboot.model.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{


}
