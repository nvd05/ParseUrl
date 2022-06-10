public final class UrlFilter
{
	public static boolean checkPath(Integer offset, char symbol)
	{
		return symbol != '\0'
			&& symbol != '/'
			&& symbol != '?'
			&& symbol != '#';
	}

	public static boolean checkField(Integer offset, char symbol)
	{
		return symbol != '\0'
			&& symbol != '='
			&& symbol != '?'
			&& symbol != '#';
	}

	public static boolean checkValue(Integer offset, char symbol)
	{
		return symbol != '\0'
			&& symbol != '&'
			&& symbol != '?'
			&& symbol != '#';
	}
}