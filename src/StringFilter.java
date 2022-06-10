public final class StringFilter
{
	public static boolean checkNumber(Integer offset, char symbol)
	{
		return '0' <= symbol && symbol <= '9';
	}

	public static boolean checkString(Integer offset, char symbol)
	{
		return ('A' <= symbol && symbol <= 'Z')
			|| ('a' <= symbol && symbol <= 'z');
	}

	public static boolean checkField(Integer offset, char symbol)
	{
		return StringFilter.checkString(offset, symbol)
			|| StringFilter.checkNumber(offset, symbol)
			|| symbol == '_';
	}
}