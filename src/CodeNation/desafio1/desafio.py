import requests
import json
import hashlib

link = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=e113855b46bddcc9761496f7dac26cb39d30c47a"
linkEnvio = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=e113855b46bddcc9761496f7dac26cb39d30c47a"

# get requisição
req = requests.get(link)
data = req.json()
    
# Convertendo para Json
#print(req)

# Definindo variáveis
numCasas = data["numero_casas"]
cifrado = data["cifrado"]
decifrado = ""
resumo = ""

# Decifrar
for x in range(len(cifrado)):
    letra = cifrado[x]

    if letra.isalpha():
        if letra.isupper():
            decifrado += chr((ord(letra) - numCasas - 65) % 26 + 65) 
        else:
            decifrado += chr((ord(letra) - numCasas - 97) % 26 + 97)
    else:     
        decifrado += letra

data["decifrado"] = decifrado

# Resumo para sha1
resumo = str(hashlib.sha1(decifrado.encode()).hexdigest())
data["resumo_criptografico"] = resumo
print(decifrado)
print(cifrado)
print(resumo)

with open('answer.json', 'w') as arq:
   json.dump(data, arq)
   arq.close()

# Enviando Solução
files = {('answer', ('answer', open('answer.json', 'rb'), 'aplication/json'))}
req = requests.post(linkEnvio, files=files)
print(req.text)

