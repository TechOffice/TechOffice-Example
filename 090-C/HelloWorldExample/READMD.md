
HelloWorld.c 
```
#include <stdio.h>
 
int main() {
    printf("Hello, world!\n");
    return 0;
}
```

Compile HelloWorld.c to a.out
```
gcc HelloWorld.c
```

Execute the compiled HelloWorld
```
./a.out
```

Output
```
Hello, world!
```

Beside, 
The executable program could be configured as the below
```
gcc -o HelloWorld.out HelloWorld.c
```