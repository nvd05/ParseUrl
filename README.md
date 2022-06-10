# Обработчик ссылок
```java
UrlParser reader = new UrlParser("https://google.com/path/file.json?param1=value1#param2=value2");
```

* _scheme    => https
* _address   => google.com
* _path      => ['path', 'file.json']
* _arguments => {'param1': 'value1'}
* _fragments => {'param2': 'value2'}
