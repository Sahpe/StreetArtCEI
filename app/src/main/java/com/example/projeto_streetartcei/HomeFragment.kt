package com.example.projeto_streetartcei

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Configurar RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CustomAdapter(getSampleData())

        // Configurar botões
        val buttonTechniques: Button = view.findViewById(R.id.buttonTechniques)
        val buttonThemes: Button = view.findViewById(R.id.buttonThemes)
        val buttonArtists: Button = view.findViewById(R.id.buttonArtists)

        buttonTechniques.setOnClickListener {
            // Implementar ação para o botão de técnicas
        }

        buttonThemes.setOnClickListener {
            // Implementar ação para o botão de temas
        }

        buttonArtists.setOnClickListener {
            // Implementar ação para o botão de artistas
        }

        return view
    }

    private fun getSampleData(): List<String> {
        // Aqui você pode retornar os dados reais da sua base de dados
        return listOf("Card 1", "Card 2", "Card 3")
    }

    // Adapter personalizado para RecyclerView
    private class CustomAdapter(private val data: List<String>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_layout, parent, false)
            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            // Configura o conteúdo do ViewHolder aqui
            holder.bind(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }

        // ViewHolder personalizado para os itens do RecyclerView
        class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // Declare os componentes do layout do item aqui
            private val textView: TextView = itemView.findViewById(R.id.textView)

            fun bind(item: String) {
                // Implemente a lógica para exibir os dados do item no layout do RecyclerView
                textView.text = item  // Aqui você pode definir o texto do TextView com o dado do item
            }
        }
    }
}
