import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public final class UrlParser
{
	private StringReader _reader;

	public Map<String, String> _fragments;
	public Map<String, String> _arguments;

	public List<String> _path;
	public String _address;
	public String _scheme;

	private void schemeHandler()
	{
		String buffer = _reader.callbackFilter(StringFilter::checkString);

		if (_reader.checkString("://"))
		{
			_scheme = buffer;
		}
		else
		{
			_address = buffer;
		}
	}

	private void addressHandler()
	{
		_address += _reader.callbackFilter(UrlFilter::checkPath);
	}

	private void pathHandler()
	{
		while (_reader.checkSymbol('/'))
		{
			_path.add(_reader.callbackFilter(UrlFilter::checkPath));
		}
	}

	private void argumentsHandler()
	{
		if (_reader.checkSymbol('?') == false)
		{
			return;
		}

		_arguments = parametersHandler();
	}

	private void fragmentsHandler()
	{
		if (_reader.checkSymbol('#') == false)
		{
			return;
		}

		_fragments = parametersHandler();
	}

	private Map<String, String> parametersHandler()
	{
		Map<String, String> response = new HashMap<>();

		do
		{
			String field = _reader.callbackFilter(UrlFilter::checkField);
			String value = _reader.checkSymbol('=')
				? _reader.callbackFilter(UrlFilter::checkValue)
				: null;

			response.put(field, value);
		}
		while (_reader.checkSymbol('&'));

		return response;
	}

	public UrlParser(String url)
	{
		_reader = new StringReader(url);

		_fragments = new HashMap<>();
		_arguments = new HashMap<>();
		_path = new ArrayList<>();
		_address = "";
		_scheme = "";

		schemeHandler();
		addressHandler();
		pathHandler();
		argumentsHandler();
		fragmentsHandler();
	}
}