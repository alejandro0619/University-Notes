compras = [ "harina", "queso", "salsa", "harina"]
#             0           1       2        3
# N = cantidad elementos -> N - 1 ultimo indice -> 3 - 1

print(compras)
deleted = False

if len(set(compras)) == len(compras):
  print("No hay elementos repetidos")
else:
  print("Si hay elementos repetidos")
  
for i in range(len(compras)):
  if deleted:
    break
  else:
    for j in range(1, len(compras)):
      if compras[i] == compras[j] and j != i:
        del compras[j]
        deleted = True

print(compras)

