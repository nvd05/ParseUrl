public final class StringReader extends StringBuffer
{
	public String callbackFilter(StringCaller callback)
	{
		String  buffer = "";
		Integer offset = 0;

		while (isEnd(0) == false)
		{
			char   symbol = getSymbol(0);
			Object result = callback.run(offset, symbol);

			if (result == null)
			{
				continue;
			}

			if ((boolean) result == false)
			{
				break;
			}

			if ((boolean) result == true)
			{
				result = symbol;
			}

			movePosition(1);
			buffer += result;
			offset++;
		}

		return buffer;
	}

	public boolean checkString(String data)
	{
		char[] buffer = data.toCharArray();
		int    length = buffer.length;

		for (int offset = 0; offset < length; offset++)
		{
			if (getSymbol(offset) != buffer[offset])
			{
				return false;
			}
		}

		movePosition(length);
		return true;
	}

	public boolean checkSymbol(char symbol)
	{
		if (getSymbol(0) == symbol)
		{
			movePosition(1);
			return true;
		}

		return false;
	}

	public StringReader(String buffer)
	{
		super(buffer);
	}
}