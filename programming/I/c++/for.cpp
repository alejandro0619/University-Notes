// Bucle for.

#include <iostream>

using namespace std;

int main(){
  int i1, cond1,i2,cond2;
  cout << "Dame i: " << endl;
  cin >> i1;
  cout << "Dame i2: " << endl;
  cin >> i2;
  cout << "Dame condicion " << endl;
  cin >> cond1;
  cout << "Dame condicion 2 " << endl;
  cin >> cond2;

  //     inicializar variable local
  //     condicion
  //     modificar la variable local

  // for 1
  for (; i1 <= cond1; i1++) // indice ++
  {
    // for 2
    for (; i2 >= cond2; i2--){
      cout << "Indice uno: " << i1 << " Indice dos: " << i2 << endl;
    }
  }
// codigo...
cout << "Ya salio el bucle " << endl;

  return 0;
}