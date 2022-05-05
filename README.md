# MealDB

[![](https://img.shields.io/github/v/tag/thechampagne/mealdb-java?label=version)](https://github.com/thechampagne/mealdb-java/releases/latest) [![](https://img.shields.io/github/license/thechampagne/mealdb-java)](https://github.com/thechampagne/mealdb-java/blob/main/LICENSE)

TheMealDB API client for **Java**.

### Download

Replace the **VERSION** key below with the version shown above.

**Gradle**
```gradle
dependencies {
    implementation 'io.github.thexxiv:mealdb:VERSION'
}
```

**Maven**
```xml
<dependency>
    <groupId>io.github.thexxiv</groupId>
    <artifactId>mealdb</artifactId>
    <version>VERSION</version>
</dependency>
```

### Example

```java
public static void main(String[] args) {
    System.out.println(MealDB.search("Shawarma"));
    System.out.println(MealDB.random());
}
```

### License

MealDB is released under the [Apache License 2.0](https://github.com/thechampagne/mealdb-java/blob/main/LICENSE).

```
 Copyright 2022 XXIV

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```