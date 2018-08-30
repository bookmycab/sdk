package uber;

import com.uber.sdk.core.client.ServerTokenSession;
import com.uber.sdk.core.client.SessionConfiguration;
import com.uber.sdk.rides.client.UberRidesApi;
import com.uber.sdk.rides.client.model.Product;
import com.uber.sdk.rides.client.model.ProductsResponse;
import com.uber.sdk.rides.client.model.Ride;
import com.uber.sdk.rides.client.model.RideRequestParameters;

import java.io.IOException;
import java.util.List;

public class sample1 {

    public static void main(String[] args) throws IOException {
        SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId("ViNeSrP31VxxAm6xtUyymS8RlhN0qhJq")
                .setServerToken("Cq-TsOj5C_CFy5BSo2b8vSAvU6ZuDp8roTqPTi3B").setClientSecret("jnDIdRLNRBnJoMj9gpG0AxYLT8PPgl2Kc8wiOFHm")
                .setRedirectUri("http://anshu.com")
                .build();

        ServerTokenSession session = new ServerTokenSession(config);
        UberRidesApi service = UberRidesApi.with(session).build();
        System.out.println(service.createService().getUserProfile());
        retrofit2.Response<ProductsResponse> response = service.createService().getProducts(17.462090f, 78.343975f).execute();
        List<Product> products = response.body().getProducts();
        System.out.println(products.get(4).getDisplayName());
        for(Product p:products){
            //System.out.println(p.getDisplayName());
           // System.out.println(p.getDescription());
        }

        /*RideRequestParameters rideRequestParameters = new RideRequestParameters.Builder().setPickupCoordinates(17.462090f, 78.343975f)
                .setProductId(products.get(4).getProductId())
                .setDropoffCoordinates(17.462090f, 78.343975f)
                .build();
        RideEstimate rideEstimate = service.createService().estimateRide(rideRequestParameters).execute().body();
        System.out.println(rideEstimate);
        RideEstimate.Fare fareId = rideEstimate.getFare();
        System.out.println(fareId);*/

        RideRequestParameters rideRequestParameters1 = new RideRequestParameters.Builder().setPickupCoordinates(17.462090f, 78.343975f)
                .setProductId(products.get(4).getProductId())
                .setDropoffCoordinates(32.811944f, 66.861389f)
                .build();
        Ride ride = service.createService().requestRide(rideRequestParameters1).execute().body();
        System.out.println(ride.getDestination());
        /*String rideId = ride.getRideId();
        System.out.println(rideId);*/
    }
}
