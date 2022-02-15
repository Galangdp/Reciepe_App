package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recipeapp.data.Recipes
import com.example.recipeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        //todo membuat arrow back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPED_DATA) as Recipes

        Glide.with(this).load(dataRecipes.photo).into(binding.imgDetail)

        //binding.apply the function is if you mau masukin id biar lebih mudah itu begini lebih hemat
        // binding.apply cukup di awal aja nulis binding nya
        // cara lama
        // binding.tvNameRecipeDetail.text = dataRecipes.name

        //todo cara cepet
        binding.apply {
            txtNamaDetail.title = dataRecipes.name
            tvNameRecipeDetail.text = dataRecipes.name
            tvCaloriesDetail.text = dataRecipes.calories
            tvCarboDetail.text = dataRecipes.carbo
            tvProteinDetail.text = dataRecipes.protein
            tvDescriptionDetail.text = dataRecipes.description
            tvIngredientsDetail.text = dataRecipes.ingredients
            tvInstructionDetail.text = dataRecipes.instructions
        }
    }
    companion object{
        const val RECIPED_DATA = "Recipes"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}