#!/usr/bin/env python3

harga = float(input("Masukkan harga barang: "))
diskon = float(input("Masukkan persen diskon: "))

potongan = harga * diskon / 100
harga_akhir = harga - potongan

print("=" * 25)
print(f"Harga awal: Rp {harga:,.0f}")
print(f"Diskon: {diskon}%")
print(f"Potongan: Rp {potongan:,.0f}")
print(f"Harga akhir: Rp {harga_akhir:,.0f}")