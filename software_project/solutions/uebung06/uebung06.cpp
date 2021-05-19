#include <iostream>

#include "RE.hpp"
#include "orakel.hpp"

using namespace std;

/*
 * definition of a test noTestCases
 */
struct TestCase {
    RE* expression;
    string inputString;
};

/*
 * compare expressions by string
 */
bool compareExpression ( RE* expression, string testString ) {
    bool result = orakel ( expression, expression->simp(), testString );

    cout << "Expression: \"" << expression->pretty() << "\"" << endl;
    cout << "Expression simplified: \"" << expression->simp()->pretty() << "\"" << endl;
    cout << "Test-String: \"" << testString << "\"" << endl;

    if ( result ) {
        cout << "Expressions are equal." << "\t\t[  OK  ]" << endl << endl;
    } else {
        cout << "Expressions are unequal." << "\t\t[FAILED]" << endl << endl;
    }

    return result;
}

/*
 * run all given tests
 */
void runTests ( TestCase* testCases, int noTestCases ) {
    for ( int i = 0; i < noTestCases; i++ ) {
        compareExpression ( testCases[i].expression, testCases[i].inputString );
    }
}

/*
 * main for definition of test noTestCases
 */
int main() {

//     phi + c
//     RE* r3 = new Alt ( new Phi(), new Ch ( 'c' ) );
//
//     c + phi
//     RE* r4 = new Alt ( new Ch ( 'c' ), new Phi() );
//
//     cout << r3->pretty() << endl;
//
//     cout << r3->simp()->pretty() << endl;
//
//     c**
//     RE* r5 = new Star ( new Star ( new Ch ( 'c' ) ) );
//     cout << r5->pretty() << endl;
//     cout << r5->simp()->pretty() << endl;
//
//     phi*
//     RE* r6 = new Star ( new Phi() );
//
//     cout << r6->pretty() << endl;
//     cout << r6->simp()->pretty() << endl;
//
//     (phi + c) + c**
//     RE* r7 = new Alt ( r3,r5 );
//
//     cout << r7->pretty() << endl;
//     exhaustively apply simplifications
//     cout << simpFix ( r7 )->pretty() << endl;
//
//     cout << endl << "Example from the worksheet:" << endl;
//     RE* expression = new Conc ( new Eps(), new Conc ( new Star ( new Star ( new Ch ( 'a' ) ) ), new Alt ( new Phi(), new Ch ( 'b' ) ) ) );
//     cout << expression->pretty() << endl;
//     cout << simpFix ( expression )->pretty() << endl;

    int noTestCases = 15;
    TestCase testCases[noTestCases];

    /*
     * phi
     */

    // phi
    testCases[0].expression = new Phi ();
    testCases[0].inputString = "a";

    /*
     * epsilon
     */

    // eps
    testCases[1].expression = new Eps ();
    testCases[1].inputString = "a";

    /*
     * character
     */

    // a  --  a
    testCases[2].expression = new Ch ( 'a' );
    testCases[2].inputString = "a";

    // a  --  aa
    testCases[3].expression = new Ch ( 'a' );
    testCases[3].inputString = "aa";

    // a  ---  b
    testCases[4].expression = new Ch ( 'a' );
    testCases[4].inputString = "b";

    /*
     * alternative
     */

    // a + a  ---  a
    testCases[5].expression = new Alt(new Ch ('a'), new Ch('a'));
    testCases[5].inputString = "a";
    
    // a + phi  ---  a
    testCases[6].expression = new Alt(new Ch ('a'), new Phi());
    testCases[6].inputString = "a";

    // phi + a  ---  a
    testCases[7].expression = new Alt(new Phi(), new Ch('a'));
    testCases[7].inputString = "a";

    /*
     * concatenate
     */

    // eps a  ---  a
    testCases[8].expression = new Conc(new Eps(), new Ch('a'));
    testCases[8].inputString = "a";

    // a eps  ---  a
    testCases[9].expression = new Conc(new Ch('a'), new Eps());
    testCases[9].inputString = "a";

    // a phi  ---  a
    testCases[10].expression = new Conc(new Ch('a'), new Phi());
    testCases[10].inputString = "a";

    // phi a  ---  a
    testCases[11].expression = new Conc(new Phi(), new Ch('a'));
    testCases[11].inputString = "a";

    /*
     * star
     */

    // a**
    testCases[12].expression = new Star(new Star(new Ch('a')));
    testCases[12].inputString = "aaa";

    // (a* a)*  ---  aaab
    testCases[13].expression = new Star(new Conc(new Star(new Ch('a')), new Ch('a')));
    testCases[13].inputString = "aaab";

    // phi*
    testCases[14].expression = new Star(new Phi());
    testCases[14].inputString = "a";


    // run the tests
    runTests ( testCases, noTestCases );
}
