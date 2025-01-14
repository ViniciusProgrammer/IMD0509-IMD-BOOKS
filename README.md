# 📚 App IMDBOOKS

Aplicativo Android para gerenciamento de livros desenvolvido como projeto para a disciplina de Programação para Dispositivos Móveis (UFRN).

## 📋 Descrição

O aplicativo permite o gerenciamento completo de um catálogo de livros, incluindo funcionalidades de cadastro, listagem, atualização e remoção de livros. O sistema conta com autenticação de usuários e armazenamento local dos dados.

## ✨ Funcionalidades

### Autenticação
- Login de usuários
- Cadastro de novos usuários
- Recuperação de senha disponível para o usuário

### Gerenciamento de Livros
- Cadastro de novos livros
- Listagem de todos os livros cadastrados
- Visualização detalhada de cada livro
- Atualização de informações
- Exclusão de livros
- Busca por ISBN

### Informações Armazenadas
- Título
- Autor
- Editora
- ISBN (identificador único)
- Descrição
- URL da capa do livro

## 🛠️ Tecnologias Utilizadas

## 📱 Core
- **Android SDK**
- **XML** para layouts
- **Material Design**

## 📚 Bibliotecas e Frameworks
- **AndroidX**
 - RecyclerView
 - AppCompat
 - ConstraintLayout
- **Glide/Picasso** para carregamento de imagens

## 💾 Armazenamento
- **SQLite** - Banco de dados local
- **SharedPreferences** - Armazenamento de dados de login

## 🎨 Componentes UI
### Layouts
- ScrollView
- LinearLayout 
- ConstraintLayout
- RecyclerView + Adapter

### Elementos
- ImageView
- TextView
- EditText
- Button

## 🔧 Recursos
- **Intents** - Navegação entre telas
- Sistema de cores personalizado
- Drawables e recursos de design
- Tools e namespaces Android

## 📐 Design
- Sistema de dimensionamento (dp/sp)
- Material Design Components
- Layouts responsivos

## ⌨️ Tipos de Input
- textEmailAddress
- textPassword  
- textPersonName
- textMultiLine
- textUri
- number

## ✅ Sistema de Validação
- InputType
- Constraints de layout
- Validação de formulários

## 🚀 Preparação do Ambiente

#### 1. Faça o download do repositório utilizando o comando:

```bash
git clone git@github.com:ViniciusProgrammer/IMD0509-IMD-BOOKS.git
```

#### 2. Abra o projeto no Android Studio e configure o ambiente, se necessário..
#### 3. Conecte um dispositivo Android físico ou inicie um emulador compatível.
#### 4. Realize a compilação e execute o aplicativo diretamente pelo Android Studio.

#### 📲 Como Usar

#### 1. Inicie o aplicativo no dispositivo ou emulador.
#### 2. Crie uma conta ou entre com suas credenciais existentes.
#### 3. Utilize a tela principal para gerenciar os livros: adicione, visualize, edite ou exclua conforme necessário.
