#include <iostream>
#include <string>
using namespace std;

int main() {
    int tc;
    string ans("");

    cin >> tc;

    while (tc--) {
        int A, B;
        cin >> A >> B;
        ans.append(to_string(A+B)).append("\n");
    }

    cout << ans;
}