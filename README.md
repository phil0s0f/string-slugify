# String Slugify

A small Java library for converting text into URL-friendly slugs.

## Requirements

Java 11 or higher.

## Installation

```xml

<dependency>
    <groupId>io.github.phil0s0f</groupId>
    <artifactId>string-slugify</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

```java
import io.github.phil0s0f.slugify.Slugifier;

public class Example {
    public static void main(String[] args) {
        String slug = Slugifier.slugify("Hello, World!");
        System.out.println(slug); // hello-world
    }
}
```

### Custom separator

```java
import io.github.phil0s0f.slugify.Slugifier;
import io.github.phil0s0f.slugify.SlugifyOptions;

SlugifyOptions options = SlugifyOptions.builder()
        .separator("_")
        .build();

String slug = Slugifier.slugify("Hello, World!", options);
// hello_world
```

## License

Apache License 2.0