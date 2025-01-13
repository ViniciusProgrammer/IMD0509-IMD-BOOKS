package com.example.imdbookstore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbookstore.model.Livro
import com.example.imdbookstore.R

class LivroAdapter(
    private val livros: List<Livro>,
    private val onItemClick: (Livro) -> Unit
) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

    inner class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.findViewById<TextView>(R.id.textViewTitulo)
        val autor = view.findViewById<TextView>(R.id.textViewAutor)
        val capa = view.findViewById<ImageView>(R.id.imageViewCapa)
        val editora = view.findViewById<TextView>(R.id.textViewEditora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]
        holder.titulo.text = livro.titulo
        holder.autor.text = livro.autor
        holder.editora.text = livro.editora

        holder.capa.setImageResource(R.drawable.loading_spinner)

        val rotateAnimation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.rotate)
        holder.capa.startAnimation(rotateAnimation)

        try {
          // Adiciona um atraso antes de carregar a imagem
          Handler(Looper.getMainLooper()).postDelayed({
            Glide.with(holder.itemView.context)
                .load(livro.imagemUrl)
                .placeholder(R.drawable.loading_spinner)
                .error(R.drawable.error_book)
                .centerCrop()
                .into(holder.capa)

              holder.capa.clearAnimation()
          }, 1000) // 1 seconds delay
        } catch (e: Exception) {
            holder.capa.setImageResource(R.drawable.error_book)
            holder.capa.clearAnimation()
        }
            
        holder.itemView.setOnClickListener { onItemClick(livro) }
    }

    override fun getItemCount() = livros.size
}