int a = 5;
float b = 2.5;
int list[3];
int result = 0;

list[0] = 10;
list[1] = 20;
list[2] = 30;

if (a > 3) {
    result = a * 2;
} else {
    result = a + 1;
}

int i = 0;
while (i < 3) {
    result = result + list[i];
    i = i + 1;
}

print(result);
