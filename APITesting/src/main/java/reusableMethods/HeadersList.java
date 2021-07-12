package reusableMethods;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeadersList {




	public static Headers getMultipleHeaders()
	{
	List<Header> headerlist = new ArrayList<Header>();
	headerlist.add(new Header("Content-Type", "application/json"));
    Headers headers = new Headers(headerlist);
	return headers;

}


}
