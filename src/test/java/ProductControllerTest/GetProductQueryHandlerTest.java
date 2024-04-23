package ProductControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.aquweak.demo.DemoApplication;
import com.aquweak.demo.Product.ProductRepository;
import com.aquweak.demo.Product.Model.Product;
import com.aquweak.demo.Product.queryhandlers.GetProductQueryHandler;

@SpringBootTest(classes = DemoApplication.class)
public class GetProductQueryHandlerTest {

    private java.util.Optional x;

    @InjectMocks
    private GetProductQueryHandler getProductQueryHandler;
    
    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProductQueryHandler_validId_returnsProduct(){
        Product product = new Product();
        product.setId(10);
        product.setName("Iphone X");
        product.setDescription("test");
        product.setPrice(600.00);
        product.setQuantity(20);

        when(productRepository.findById(product.getId())).thenReturn(x.of(product));

        ResponseEntity response = getProductQueryHandler.execute(product.getId());
        assertEquals(product, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
