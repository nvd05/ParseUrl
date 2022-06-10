public final class App
{
	public static void main(String[] args) throws Exception
	{
		UrlParser reader = new UrlParser("https://oauth.vk.com/blank.html?hello=world#access_token=TEST_TOKEN&user_id=0");

		System.out.println("address: "   + reader._address);
		System.out.println("scheme: "    + reader._scheme);
		System.out.println("path: "      + reader._path);
		System.out.println("arguments: " + reader._arguments);
		System.out.println("fragments: " + reader._fragments);
	}
}
