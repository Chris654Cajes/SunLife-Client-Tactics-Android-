package com.sunlife.clienttactics.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.card.MaterialCardView
import com.sunlife.clienttactics.R
import com.sunlife.clienttactics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedCategory: String? = null
    private var selectedReason: String? = null

    private val categories = listOf(
        "Lack of Trust or Credibility",
        "Price / Affordability Concerns",
        "Lack of Perceived Need",
        "Poor Timing",
        "Information Overload / Confusion",
        "Lack of Urgency",
        "Emotional Resistance",
        "Comparison / Shopping Around",
        "Product Mismatch",
        "External Influence",
        "Negative Industry Perception",
        "Advisor Approach Issues",
        "Commitment Hesitation",
        "Already Covered",
        "Hidden Objections"
    )

    private val reasonsMap = mapOf(
        "Lack of Trust or Credibility" to listOf(
            "Client does not trust the advisor yet",
            "Advisor appears too sales-oriented",
            "Past negative experience with insurance or agents",
            "Skepticism about claims payout reliability"
        ),
        "Price / Affordability Concerns" to listOf(
            "Premium is too expensive",
            "Perceived low value for the cost",
            "Other financial priorities take precedence",
            "Fear of long-term financial commitment"
        ),
        "Lack of Perceived Need" to listOf(
            "Client feels too young or healthy",
            "Belief that existing coverage is sufficient",
            "Optimism bias (nothing bad will happen)",
            "No dependents or responsibilities"
        ),
        "Poor Timing" to listOf(
            "Currently not financially ready",
            "Recent major expenses",
            "Overwhelmed with other decisions",
            "Prefers to delay decision"
        ),
        "Information Overload / Confusion" to listOf(
            "Too many options presented",
            "Complex terms not understood",
            "Unclear explanation of benefits",
            "Client does not fully understand the product"
        ),
        "Lack of Urgency" to listOf(
            "No immediate need or trigger",
            "No perceived consequences of delay",
            "Insurance seen as a future concern"
        ),
        "Emotional Resistance" to listOf(
            "Discomfort discussing death or illness",
            "Avoidance mindset",
            "Fear of long-term commitments"
        ),
        "Comparison / Shopping Around" to listOf(
            "Client is evaluating multiple advisors",
            "Competing offers seem more attractive",
            "Waiting to compare before deciding"
        ),
        "Product Mismatch" to listOf(
            "Plan does not fit client needs",
            "Coverage amount is inappropriate",
            "Payment terms are not suitable"
        ),
        "External Influence" to listOf(
            "Family or partner disagrees",
            "Influenced by friends or relatives",
            "Another trusted advisor is involved"
        ),
        "Negative Industry Perception" to listOf(
            "Belief that insurance is a scam",
            "Stories of denied claims",
            "General distrust of financial products"
        ),
        "Advisor Approach Issues" to listOf(
            "Advisor talks too much and does not listen",
            "Pushy sales approach",
            "Lack of personalization",
            "Weak follow-up or closing"
        ),
        "Commitment Hesitation" to listOf(
            "Fear of long-term payments",
            "Fear of making the wrong decision",
            "Preference to delay commitment"
        ),
        "Already Covered" to listOf(
            "Existing policies are considered sufficient",
            "Company benefits or HMO coverage perceived as enough"
        ),
        "Hidden Objections" to listOf(
            "Client says they will think about it",
            "Client claims to be too busy",
            "Client postpones to a later time",
            "Underlying lack of trust",
            "Unclear perceived value",
            "Not fully convinced"
        )
    )

    private val suggestionsMap = mapOf(
        "Client does not trust the advisor yet" to listOf(
            "Build rapport first before presenting any product",
            "Share client testimonials or case studies",
            "Focus on understanding client needs instead of selling"
        ),
        "Advisor appears too sales-oriented" to listOf(
            "Shift to a consultative approach",
            "Ask more questions than you talk",
            "Avoid pushing for immediate decisions"
        ),
        "Premium is too expensive" to listOf(
            "Offer flexible payment options",
            "Present lower coverage alternatives",
            "Break down cost into daily or monthly equivalents"
        ),
        "Client feels too young or healthy" to listOf(
            "Explain benefits of locking in lower premiums early",
            "Share examples of unexpected events",
            "Position insurance as proactive planning"
        ),
        "Currently not financially ready" to listOf(
            "Offer smaller starter plans",
            "Schedule a follow-up at a better time",
            "Provide budgeting guidance"
        ),
        "Too many options presented" to listOf(
            "Limit choices to 2-3 options",
            "Recommend a best-fit plan",
            "Guide decision-making clearly"
        ),
        "No immediate need or trigger" to listOf(
            "Create awareness of risks",
            "Share real-life unexpected scenarios",
            "Relate to their personal situation"
        ),
        "Discomfort discussing death or illness" to listOf(
            "Approach topic gently",
            "Focus on protection and security",
            "Use positive framing"
        ),
        "Client is evaluating multiple advisors" to listOf(
            "Differentiate your approach",
            "Highlight your unique value",
            "Build stronger personal connection"
        ),
        "Plan does not fit client needs" to listOf(
            "Reassess client needs",
            "Customize the plan",
            "Ask deeper discovery questions"
        ),
        "Family or partner disagrees" to listOf(
            "Invite them into the discussion",
            "Address their concerns directly",
            "Provide family-focused benefits"
        ),
        "Belief that insurance is a scam" to listOf(
            "Provide transparency",
            "Show regulation and company credibility",
            "Share real customer experiences"
        ),
        "Advisor talks too much and does not listen" to listOf(
            "Practice active listening",
            "Use more open-ended questions",
            "Let the client speak more"
        ),
        "Fear of long-term payments" to listOf(
            "Break payments into smaller terms",
            "Show flexibility options",
            "Highlight affordability strategies"
        ),
        "Existing policies are considered sufficient" to listOf(
            "Review existing coverage",
            "Identify protection gaps",
            "Provide comparison analysis"
        ),
        "Client says they will think about it" to listOf(
            "Ask what specifically they want to think about",
            "Clarify concerns",
            "Set a follow-up schedule"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        WindowCompat.setDecorFitsSystemWindows(window, false)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupWindowInsets()
        setupCategoryDropdown()
        setupButtons()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(top = insets.top, bottom = insets.bottom)
            windowInsets
        }
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(R.color.status_bar_color)
            window.navigationBarColor = getColor(R.color.navigation_bar_color)
        }
    }

    private fun setupCategoryDropdown() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, categories)
        binding.actvCategory.setAdapter(adapter)
        
        binding.actvCategory.setOnItemClickListener { parent, view, position, id ->
            selectedCategory = categories[position]
            setupReasonDropdown(categories[position])
        }
    }

    private fun setupReasonDropdown(category: String) {
        val reasons = reasonsMap[category] ?: emptyList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, reasons)
        binding.actvReason.setAdapter(adapter)
        
        binding.actvReason.setOnItemClickListener { parent, view, position, id ->
            selectedReason = reasons[position]
        }
        
        binding.actvReason.text?.clear()
        binding.tilReason.visibility = View.VISIBLE
        binding.tilReason.isEnabled = true
    }

    private fun setupButtons() {
        binding.tilReason.visibility = View.GONE
        
        binding.btnGetSuggestions.setOnClickListener {
            when {
                selectedCategory == null -> {
                    Toast.makeText(this, R.string.msg_select_category_first, Toast.LENGTH_SHORT).show()
                }
                selectedReason == null -> {
                    Toast.makeText(this, R.string.msg_select_reason_first, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    showSuggestionsDialog()
                }
            }
        }
    }

    private fun showSuggestionsDialog() {
        val suggestions = suggestionsMap[selectedReason] ?: listOf(
            "Build relationship first",
            "Listen more, talk less",
            "Follow up consistently",
            "Provide clear documentation"
        )
        
        val container = LinearLayout(this)
        container.orientation = LinearLayout.VERTICAL
        container.setPadding(48, 24, 48, 24)
        
        // Title
        val titleText = TextView(this)
        titleText.text = "$selectedCategory > $selectedReason"
        titleText.setTextColor(getColor(R.color.text_primary))
        titleText.textSize = 16f
        container.addView(titleText)
        
        // Divider
        val divider = View(this)
        val dividerParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2)
        dividerParams.topMargin = 24
        dividerParams.bottomMargin = 24
        divider.layoutParams = dividerParams
        divider.setBackgroundColor(getColor(R.color.surface))
        container.addView(divider)
        
        // Add suggestion cards
        for (suggestion in suggestions) {
            val card = MaterialCardView(this)
            card.radius = 24f
            card.cardElevation = 4f
            card.setCardBackgroundColor(getColor(R.color.surface))
            
            val cardParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            cardParams.bottomMargin = 16
            card.layoutParams = cardParams
            
            val tv = TextView(this)
            tv.text = suggestion
            tv.setTextColor(getColor(R.color.text_primary))
            tv.textSize = 14f
            tv.setPadding(32, 24, 32, 24)
            
            card.addView(tv)
            container.addView(card)
        }
        
        MaterialAlertDialogBuilder(this)
            .setTitle("Suggestions for Recovery")
            .setView(container)
            .setPositiveButton("Close", null)
            .show()
    }
}