/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ProductService;

import org.junit.jupiter.api.Test;

import com.onlinestore.products.ProductServiceApplication;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void someLibraryMethodReturnsTrue() {
        ProductServiceApplication classUnderTest = new ProductServiceApplication();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
}