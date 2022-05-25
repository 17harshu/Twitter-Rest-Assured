import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class TwitterRest {
    @Test
    //API key","API secret","Acesstoken","Access secret
    public void twitterPost() {
        Response response = RestAssured.given()
                .auth().oauth("hkRVTHSrvVdp8pmMzmPJRqvBr",
                        "8On2hTqfSnBOS9Gd8EYM24tBGXbKMzdCzNmp1hWb8Jx2NdKJFw",
                        "1527630669891121153-VBOmaixuJyaWssUpxFCl0YwuXO4gM6",
                        "4bChZtz2lEjmWDesxHaqD1TJVrYloyjioasH6El7xr6QJ")
                .post("https://api.twitter.com/1.1/statuses/update.json?status= Good Evening");
        System.out.println(response.prettyPrint());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID:" + jsonPath.get("id_str"));

    }

    @Test
    public void retweetPost() {
        Response response = RestAssured.given()
                .auth().oauth("hkRVTHSrvVdp8pmMzmPJRqvBr",
                        "8On2hTqfSnBOS9Gd8EYM24tBGXbKMzdCzNmp1hWb8Jx2NdKJFw",
                        "1527630669891121153-VBOmaixuJyaWssUpxFCl0YwuXO4gM6",
                        "4bChZtz2lEjmWDesxHaqD1TJVrYloyjioasH6El7xr6QJ")
                .post("https://api.twitter.com/1.1/statuses/retweet/1528724296733892608.json");
        System.out.println(response.prettyPrint());

    }

    @Test
    public void Deletetweet() {
        Response response = RestAssured.given()
                .auth().oauth("hkRVTHSrvVdp8pmMzmPJRqvBr",
                        "8On2hTqfSnBOS9Gd8EYM24tBGXbKMzdCzNmp1hWb8Jx2NdKJFw",
                        "1527630669891121153-VBOmaixuJyaWssUpxFCl0YwuXO4gM6",
                        "4bChZtz2lEjmWDesxHaqD1TJVrYloyjioasH6El7xr6QJ")
                .delete("https://api.twitter.com/2/tweets/1528724296733892608");
        System.out.println(response.prettyPrint());

    }
}
