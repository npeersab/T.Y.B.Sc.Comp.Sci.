#include <stdio.h>
#include <stdlib.h>

int mem[100], pc = 0, reg[4], cc[6], lc = 0;

void load();
void print();
void run();

int main() {

	int choice;
	
	do {
	
		printf("1: Load\n2: Print\n3: Accept\n4: Run\n5: Trace\n6: Quit\nChoose Option : ");
		scanf(" %d", &choice);
		
		switch(choice) {
		
			case 1 :
				load();
				break;
			case 2 :
				print();
				break;
			case 3 :
				break;
			case 4 :

			case 6 :
				exit(0);
		}
		
	} while(choice != 6);

}

void load() {

	char filename[20];
	FILE *fp;
	int address, content;

	printf("File name : ");
	scanf("%s", &filename);

	if((fp = fopen(filename, "r"))) {
		while(!feof(fp)) {
			fscanf(fp, "%d%d", &address, &content);
			if(address == -1) {
				pc = content;
				break;
			}
			else {
				mem[address] = content;
				lc = address;
			}
		}
	}
}

void print() {

	int i;

	for(i = pc; i <= lc; i++) {
		printf("%d %d\n", i, mem[i]);
	}
}

void execute() {

	for(i = lc; i < pc; i++

}
