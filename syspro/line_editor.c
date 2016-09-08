#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define NEWLINE (list *) malloc(sizeof(list))

typedef struct editbuff {

	char *line;
	struct editbuff *next;
} list;

list *readFile(char *);
void displayLines(list *);
void eprint(list *, int, int);
int countLines(list *);
list *einsert(list *, int, int *);
list *append(list *, int *);
list *delete(list *, int, int , int *);
list *move(list *, int, int, int);
list *copy(list *, int, int, int, int *);
char *save(list *, int, char *);
int isexists(char *);
void find(list *, int, int);

int main(int filecnt, char *args[]) {

	list *head = NULL;
	char c, ip[10];
	int n, n1, n2, n3, cnt;
	
	if(filecnt > 1) {
		
		head = readFile(args[1]);
		displayLines(head);
		printf("Total Lines : %d\n", cnt = countLines(head));
	}

	while(1) {

		if(args[1])
			printf("%s@editor$ ", args[1]);
		else
			printf("new file@editor$ ");
getip:
		fgets(ip, 10, stdin);
		n = sscanf(ip, "%c %d %d %d", &c, &n1, &n2, &n3);
		if(c == '\n')
			goto getip;
		switch(n) {
			case 1 :
				n1 = n2 = 1;
				break;
			case 2 :
				if(n1 > cnt)
					n1 = cnt;
				if(cnt == 0)
					n1 = 1;
				n2 = n1;
				break;
			case 3 :
				if(n2 > cnt)
					n2 = cnt;
				if(n1 > n2)
					printf("Invalid Command\n");
				break;
			case 4 :
				if(n3 > cnt)
					n3 = cnt;
				break;
			
		}
		switch(c) {

			case 'p' :
				eprint(head, n1, n2);
				break;
			case 'i' :
				head = einsert(head, n1, &cnt);
				break;
			case 'a' :
				head = append(head, &cnt);
				break;
			case 'd' :
				head = delete(head, n1, n2, &cnt);
				break;
			case 'm' :
				head = move(head, n1, n2, n3);
				break;
			case 'c' :
				head = copy(head, n1, n2, n3, &cnt);
				break;
			case 's' :
				args[1] = save(head, cnt, args[1]);
				break;
			case 'f' :
				find(head, n1, n2);
				break;
			case 'q' :
				exit(0);
		}
	}
}

list *readFile(char *fname) {

	FILE *fp;
	char str[80];
	list *last = NULL, *head = NULL, *temp;

	head = NULL;	
	if(fp = fopen(fname, "r")) {

		while(!feof(fp)) {
			if(fgets(str, 80, fp)) {
				temp = NEWLINE;
				temp -> line = (char *) malloc(sizeof(str));
				strcpy(temp -> line, str);
				temp -> next = NULL;
				if(!head) {
					last = head = temp;
				}
				else {
					last -> next = temp;
					last = temp;
				}
			}
		}
		fclose(fp);
	}
	return head;
}

void displayLines(list *head) {

	while((head)) { 
		printf("%s", head -> line);
		head = head -> next;
	}
}

void eprint(list *head, int n1, int n2) {

	int line;

	for(line = 1; line <= n1 && head; line++)
		head = head -> next;
	for(; line <= n2 && head; line++) {
		printf("%s", head -> line);
		head = head -> next;
	}
}

int countLines(list *head) {

	int cnt = 0;

	while(head) {
		head = head -> next;
		cnt++;
	}
	return cnt;
}

list *einsert(list *head, int n1, int *cnt) {

	int line;
	char str[80];
	list *temp, *new = NULL, *last, *end;
	
	while(1) {
	
		fgets(str, 80, stdin);
		if(!strcmp(str, ".\n"))
			break;

		temp = NEWLINE;
		temp -> line = (char *) malloc(sizeof(str));
		strcpy(temp -> line, str);
		if(!new) {
			new = end = temp;
		}
		else {
			end -> next = temp;
			end = temp;
		}
		(*cnt)++;
	}		
	if(n1 == 1) {
		end -> next = head;
		head = new;
	}
	else {
		for(temp = head, line = 1; line < n1 - 1; line++)
			temp = temp -> next;
		end -> next = temp -> next;
		temp -> next = new;
	}
	return head;
}

list *append(list *head, int *cnt) {

	char str[80];
	list *temp, *last, *new = NULL;
	int tempcnt = 0;
		
	while(1) {
		fgets(str, 80, stdin);
		if(!strcmp(str, ".\n"))
			break;
		temp = NEWLINE;
		temp -> line = (char *) malloc(sizeof(sizeof(str)));
		strcpy(temp -> line, str);
		if(new == NULL)
			new = last = temp;
		else {
			last -> next = temp;
			last = temp;
		}
		tempcnt++;	
	}
	if((*cnt)) {
		temp = head;
		while(temp -> next)
			temp = temp -> next;
		temp -> next = new;
		*cnt += tempcnt;
		return head;
	}
	*cnt = tempcnt;
	return new;
}

list *delete(list *head, int n1, int n2, int *cnt)  {

	int line;
	list *start, *end, *temp, *cur;
	
	if(head == NULL)
		return head;
	cur = head;
	for(line = 2; line < n1; line++)
		cur = cur -> next;
	
	start = cur;
	end = cur -> next;
	for(; line <= n2; line++) {
		temp = end;
		end = temp -> next;
		free(temp);
		(*cnt)--;
	}
	
	if(n1 == 1) {
		temp = head;
		head = end;
		free(temp);
		(*cnt)--;
	}
	else 
		start -> next = end;
	return head;
}

list *move(list *head, int n1, int n2, int n3) {
	
	int line;
	list *sub_start, *sub_end, *temp1, *temp2, *temp3, *temp4;

	if(head == NULL)
		return head;

	for(line = 1, sub_start = head; line < n1; line++) {
		temp1 = sub_start;
		sub_start = sub_start -> next;
	}

	for(temp2 = sub_start; line <= n2; line++) {		
		sub_end = temp2;
		temp2 = temp2 -> next;
	}
	
	if(n3 == 1) {
		sub_end -> next = head;
		head = sub_start;		
	}
	else {
		for(temp3 = head, line = 1; line < n3; line++) {

			temp4 = temp3;
			temp3 = temp3 -> next;
		}

		temp4 -> next = sub_start;
		sub_end -> next = temp3;
		temp1 -> next = temp2;

		return head;
	}
}

list *copy(list *head, int n1, int n2, int n3, int *cnt) {

        int line;
        list *sub_start, *sub_end, *temp1, *temp2;

        if(head == NULL)
                return head;

        for(line = 1, temp1 = head; line < n1; line++) {
		temp1 = temp1 -> next;
        }

        for(; line <= n2; line++) {
		temp2 = NEWLINE;
		temp2 -> line = (char *) malloc(sizeof(temp1 -> line));
		strcpy(temp2 -> line, temp1 -> line);
		if(!sub_start)
			sub_start = sub_end = temp2;
		else {
			sub_end -> next = temp2;
			sub_end = temp2;
		}
		temp1 = temp1 -> next;
		(*cnt)++;
        }

        for(temp1 = head, line = 1; line < n3; line++) {

                temp2 = temp1;
                temp1 = temp1 -> next;
        }

        temp2 -> next = sub_start;
	sub_end -> next = temp1;

        return head;
}

char *save(list *head, int cnt, char *filename) {

	char temp[50], ch;
	FILE *fp;
	
 	if(!filename) {
		printf("Filename : ");
		fgets(temp, 50, stdin);
		temp[strlen(temp) - 1] = '\0';
		filename = (char *) malloc(sizeof(temp) + 1);
		strcpy(filename, temp);
	}

	if(isexists(filename)) {
		printf("File already exists...\nOverwrite file ? (y/n) : ");
		ch = getchar();
		if(ch == 'n' || ch == 'N')
			return filename;
	}


	fp = fopen(filename, "w");
	while(head) {
		fprintf(fp, "%s", head -> line);
		head = head -> next;
	}
	fclose(fp);
	return filename;
}

int isexists(char *filename) {

	FILE *fp = fopen(filename, "r");
	if(fp)
		return 1;
	return 0;
}

void find(list *head, int n1, int n2) {

	int line;
	char pattern[80];

	for(line = 1; line < n1; line++) 
		head = head -> next;

	printf("Pattern : ");
	fgets(pattern, 80, stdin);

	for(; line <= n2 && head; line++, head = head -> next)
		if(strstr(head -> line, pattern))
			printf("%s", head -> line);	
}
