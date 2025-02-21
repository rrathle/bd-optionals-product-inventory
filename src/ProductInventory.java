import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ProductInventory collects groups of items to be shipped. It uses a 
 * ProductUtility to obtain individual product names, and to determine
 * whether each item is boxed and ready to be shipped.
 */
public class ProductInventory {
    private ProductUtility productUtility;
    private List<Integer> productIDs;

    /**
     * Constructor.
     * @param productUtility - The service used to retrieve product information
     * @param productIDs - A list of package IDs
     */
    public ProductInventory(ProductUtility productUtility, List<Integer> productIDs) {
        //
        // WARNING: DO NOT EDIT THE CONSTRUCTOR
        // Here's why: Typically, it's a good practice to validate constructor inputs.
        // However in this case, we're specifically asking for validation for these in
        // the methods will you be implementing, and the tests won't work correctly if you
        // do the validation here.
        //
        this.productUtility = productUtility;
        this.productIDs = productIDs;
    }

    /**
     * Find the product names for the IDs in the package.
     * @return Map[Integer, String] of product IDs to product names. Does not include products without names.
     */
    Map<Integer, String> findProductNames() {
        // TODO: replace stub implementation
        if(productUtility == null) {
            throw new IllegalArgumentException("productUtility is null");
        }
        if(productIDs == null ) {
            throw new IllegalArgumentException("productID is null");
        }

        Map<Integer, String> productMap = new HashMap<>();

        for(Integer productID: productIDs) {
           try {
               String productName = productUtility.findProductName(productID);
               if (productName != null) {
                   productMap.put(productID, productName);
               }
           } catch (NullPointerException e) {
               throw new IllegalArgumentException("productID is null");
           }
        }

//
//        Map<Integer, String> stubMap = new HashMap<Integer, String>();
//        for (Integer productID : productIDs) {
//            stubMap.put(productID, "");
//        }
//        return stubMap;
        return productMap;
    }

    /**
     * Determine whether product is ready to ship or not.
     * @param productID the package identifier
     * @return Optional[Boolean] containing whether a product is ready to ship.
     */
    Optional<Boolean> isProductReady(Integer productID) {
        // TODO: replace stub implementation
        try {
            Boolean prReady = productUtility.isProductReady(productID);
            return Optional.ofNullable(prReady);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("The productID was null");
        }
//        Boolean stubResult = productUtility.isProductReady(0);
//        return Optional.of(stubResult);
    }
}
