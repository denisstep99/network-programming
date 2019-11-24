package ru.ifmo.test;

import java.util.List;
import java.util.logging.Logger;

import ru.ifmo.data.Product.Product;
import ru.ifmo.data.Product.ProductDAO;

public class TestProductDAO {
    private static Logger logger = Logger.getLogger("Product.class");

    public static void main(String[] args) throws Exception {
        ProductDAO productDAO = new ProductDAO("business", "root", "root");

        TestProductDAO.testGetProductIds(productDAO);
        TestProductDAO.testGetProductAll(productDAO);
        TestProductDAO.testGetProductById(productDAO);
        TestProductDAO.testAddProduct(productDAO);
        TestProductDAO.testSetProduct(productDAO);
        TestProductDAO.testRemoveProduct(productDAO);
    }


    private static void testGetProductIds(ProductDAO productDAO) throws Exception {
        TestProductDAO.printBreak();
        logger.info("getProductIds: ");

        List<Integer> productIds = productDAO.getProductIds();
        productIds.forEach(value -> logger.info("Очередной ID: " + value.toString()));
    }


    private static void testGetProductAll(ProductDAO productDAO) throws Exception {
        List<Product> productAll = productDAO.getProductAll();
        TestProductDAO.printBreak();
        logger.info("getProductAll: ");

        productAll.forEach(value -> logger.info(
                "Информация о продуктах:\n" +
                        "ID: " + value.getId() + "\n" +
                        "Description: " + value.getDescription() + "\n" +
                        "Rate: " + value.getRate() + "\n" +
                        "Quantity: " + value.getQuantity()
        ));
    }


    private static void testGetProductById(ProductDAO productDAO) throws Exception {
        TestProductDAO.printBreak();
        logger.info("getProductById: ");

        Product product = productDAO.getProductById(1).get(0);
        logger.info("Существующий id: ");
        logger.info(
                "Информация о продукте:\n" +
                        "ID: " + product.getId() + "\n" +
                        "Description: " + product.getDescription() + "\n" +
                        "Rate: " + product.getRate() + "\n" +
                        "Quantity: " + product.getQuantity()
        );

        List<Product> products = productDAO.getProductById(10000);
        logger.info("Несуществующий id: ");
        logger.info("List length: " + products.size());
    }


    private static void testAddProduct(ProductDAO productDAO) throws Exception {
        TestProductDAO.printBreak();
        logger.info("addProduct: ");

        Product product = new Product(12, "Sony VIO", 120000, 8);
        productDAO.addProduct(product);

        Product addedProduct = productDAO.getProductById(12).get(0);
        logger.info("Добавленный обьект, полученный из БД: ");
        logger.info(
                "Информация о продукте:\n" +
                        "ID: " + product.getId() + "\n" +
                        "Description: " + product.getDescription() + "\n" +
                        "Rate: " + product.getRate() + "\n" +
                        "Quantity: " + product.getQuantity()
        );
    }


    /*
     * !!!Внимание, тест связан с предыдущим тестом и зависит от его результата!!!
     * */
    private static void testSetProduct(ProductDAO productDAO) throws Exception {
        TestProductDAO.printBreak();
        logger.info("setProduct: ");

        Product product = new Product(12, "Asus Razor", 220000, 12);

        List<Product> products = productDAO.getProductById(12);
        Product addedProduct = productDAO.getProductById(12).get(0);
        logger.info("Обновленный обьект, полученный из БД: ");
        logger.info(
                "Информация о продукте:\n" +
                        "ID: " + product.getId() + "\n" +
                        "Description: " + product.getDescription() + "\n" +
                        "Rate: " + product.getRate() + "\n" +
                        "Quantity: " + product.getQuantity()
        );
    }


    /*
    * !!!Внимание, тест связан с предыдущим тестом и зависит от его результата!!!
    * */
    private static void testRemoveProduct(ProductDAO productDAO) throws Exception {
        TestProductDAO.printBreak();
        logger.info("removeProduct: ");

        productDAO.removeProduct(12);
        List<Product> products = productDAO.getProductById(12);
        if (products.size() == 0) {
            logger.info("Successfully deleted");
        } else {
            logger.info("Element hasn't been deleted!!!");
        }
    }

    private static void printBreak() {
        logger.info("\n\n--------------------------------------------------------------------------------\n\n");
    }
}
