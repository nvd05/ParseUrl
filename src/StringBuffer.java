public class StringBuffer
{
	private char[] _buffer;
	private int _length;
	private int _offset;

	public void movePosition(int offset)
	{
		_offset += offset;
	}

	public char getSymbol(int offset)
	{
		if (isEnd(offset))
		{
			return '\0';
		}

		return _buffer[_offset + offset];
	}

	public boolean isEnd(int offset)
	{
		return _length <= _offset + offset;
	}

	public StringBuffer(String buffer)
	{
		_buffer = buffer.toCharArray();
		_length = _buffer.length;
		_offset = 0;
	}
}