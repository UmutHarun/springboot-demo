package ProductControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aquweak.demo.DemoApplication;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;
import com.aquweak.demo.Product.commandhandlers.CreateProductCommandHandler;

@SpringBootTest(classes = DemoApplication.class)
public class CreateProductCommandHandlerTest {
    @InjectMocks
    private CreateProductCommandHandler createProductCommandHandler;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void createProductCommandHandler_validProduct_returnsSuccess(){
        Product product = new Product();
        product.setName("Iphone X");
        product.setDescription("test");
        product.setPrice(600.00);
        product.setQuantity(20);

        ResponseEntity response = createProductCommandHandler.execute(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
