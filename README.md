# Deterministic Finite Automaton (DFA) Example

Bu program, Java dilinde bir Deterministik Sonlu Otomat (DFA) örneği içerir. Bu DFA, "Values.txt" dosyasından okunan kelimelerin belirli bir dilde (belirli kurallara göre) olup olmadığını kontrol eder.

## Nasıl Kullanılır

1. `Values.txt` dosyasına kontrol etmek istediğiniz kelimeleri ekleyin.
2. Programı çalıştırın.
3. Program belirli bir dilde tanınan ve tanınmayan kelimeleri rapor edecektir.

## Örnek Values.txt Dosyası
aabbc
aabc
abc
ab

## Kod Yapısı

- `DFAOrnek.java`: Ana program dosyasıdır. DFA'nın kontrolünü gerçekleştirir.
- `STATES` enum: DFA'nın farklı durumlarını temsil eder.
