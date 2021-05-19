/*
 * @file    uebung03.c
 * @brief   Extract words from an input string.
 * @author  Markus Merklinger
 */

#include <stdlib.h>
#include <stdio.h>

int isLetter();

/*
 * Returns a list of words found in input string, limited by maximum value.
 */
int breakIntoWords ( char *line, int maxwords, char *words[] ) {
    int wordCounter = 0;
    int characterCounter = 0;

    /* loop until end of input string or maximum words reached */
    while ( * ( line+characterCounter ) != '\0' && wordCounter < maxwords ) {

        /* check if current character is not a whitespace (32 decimal is whitespace character) */
        if ( * ( line+characterCounter ) != 32 ) {

            /* check if beginning of new word, either by start of string or if last character was not a letter */
            if ( ( ( line+characterCounter ) == line ) || ( * ( line+characterCounter-1 ) == 32 ) ) {
                words[wordCounter] = ( line+characterCounter );
                wordCounter++;
            }
        }
        characterCounter++;
    }

    return wordCounter;
}

// Return values for test
enum TestEnum {
    OK,
    FAIL
};
typedef enum TestEnum Test;

/*
 * Test for breakIntoWords
 */
Test testBreakIntoWords ( char* input, int maxwords, int foundwords, int wordStart[] ) {
    char* words[maxwords];
    int result = breakIntoWords ( input, maxwords, words );
    printf ( "testBreakIntoWords\n Input: \"%s\"\n Amount of words, expected / found: %d / %d\n WordStarts, expected / found: ", input, foundwords, result );

    /* check if expected number of words are found */
    if ( result == foundwords ) {
        /* check if the beginning of found words are correct */
        for ( int i = 0; i < foundwords; i++ ) {
            if ( ( input+wordStart[i] ) != words[i] ) {
                return FAIL;
            }
            printf ( "%d/%ld ", wordStart[i], ( words[i]-input ) );
        }
    } else {
        return FAIL;
    }
    return OK;
}

/*
 * main function
 */
int main() {

    /* test 1 */
    int wordStart1[] = {0, 5, 8};
    Test result1 = testBreakIntoWords ( "This is an example sentence.", 3, 3, wordStart1 );
    result1 == OK ? printf ( "\n [  OK  ]\n\n" ) : printf ( "\n [FAILED]\n\n" );


    /* test 2 */
    int wordStart2[] = {1, 6, 9, 12};
    Test result2 = testBreakIntoWords ( " This is an example sentence.", 4, 4, wordStart2 );
    result2 == OK ? printf ( "\n [  OK  ]\n\n" ) : printf ( "\n [FAILED]\n\n" );


    /* test 3 */
    int wordStart3[] = {0, 5, 8, 11, 19, 28};
    Test result3 = testBreakIntoWords ( "This is an example sentence . ", 10, 6, wordStart3 );
    result3 == OK ? printf ( "\n [  OK  ]\n\n" ) : printf ( "\n [FAILED]\n\n" );


    /* test 4 */
    int wordStart4[] = {0};
    Test result4 = testBreakIntoWords ( "This", 3, 1, wordStart4 );
    result4 == OK ? printf ( "\n [  OK  ]\n\n" ) : printf ( "\n [FAILED]\n\n" );


    /* test 5 */
    int wordStart5[] = {};
    Test result5 = testBreakIntoWords ( " ", 3, 0, wordStart5 );
    result5 == OK ? printf ( "\n [  OK  ]\n\n" ) : printf ( "\n [FAILED]\n\n" );

    return 0;
}
