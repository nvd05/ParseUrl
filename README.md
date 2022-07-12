# Обработчик ссылок
```java
UrlParser parser = new UrlParser("https://google.com/path/file.json?param1=value1#param2=value2");

parser._scheme;    // https
parser._address;   // google.com
parser._path;      // ['path', 'file.json']
parser._arguments; // {'param1': 'value1'}
parser._fragments; // {'param2': 'value2'}
```
